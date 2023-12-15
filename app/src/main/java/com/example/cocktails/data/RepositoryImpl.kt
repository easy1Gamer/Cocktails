package com.example.cocktails.data

import com.example.cocktails.data.data.remote.CocktailAPI
import com.example.cocktails.data.data.remote.DrinksRemote
import com.example.cocktails.data.local.MyDao
import com.example.cocktails.data.local.models.CocktailRoom
import com.example.cocktails.domain.Cocktail
import com.example.cocktails.domain.Ingredient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: CocktailAPI,
    private val dao: MyDao
) : Repository {
    override fun getCocktailsByName(query: String, onFailure: (String) -> Unit, onSuccess: (List<Cocktail>) -> Unit) {
        val callback = object : Callback<DrinksRemote> {
            override fun onResponse(call: Call<DrinksRemote>, response: Response<DrinksRemote>) {
                val result = response.body()?.drinks ?: emptyList()
                if (result.isEmpty()) {
                    onFailure.invoke("Что-то пошло не так...")
                } else {
                    onSuccess.invoke(result.map { it.asDomain() })
                }
            }

            override fun onFailure(call: Call<DrinksRemote>, t: Throwable) {
                onFailure.invoke(t.message ?: "Что-то пошло не так")
            }

        }

        api.getByName(query).enqueue(callback)

    }

    override fun getCocktailById(query: String, onFailure: (String) -> Unit, onSuccess: (Cocktail) -> Unit) {
        val callback = object : Callback<DrinksRemote> {
            override fun onResponse(call: Call<DrinksRemote>, response: Response<DrinksRemote>) {
                val result = response.body()
                if (result != null) {
                    onSuccess.invoke(result.drinks.first().asDomain())
                }
            }

            override fun onFailure(call: Call<DrinksRemote>, t: Throwable) {
                onFailure.invoke(t.message ?: "Что-то пошло не так")
            }
        }

        api.getById(query).enqueue(callback)

    }

    override fun getCocktails(): List<Cocktail> {
        return dao.getAll().map { it.asDomain() }
    }

    override fun insertCocktails(cocktails: List<Cocktail>) {
        dao.insertAllCocktails(cocktails.map { it.asRoom() })
    }

    override fun insertIngredients(ingredients: List<Ingredient>, cocktailId: String) {
        dao.insertAllIngredients(ingredients.map { it.asRoom(cocktailId) })
    }


    override fun update(cocktail: Cocktail) {
        dao.update(cocktail.asRoom())
    }

    override fun getLocalCocktailById(cocktailId: String): Cocktail {
        val cocktailIngredientRoom = dao.getCocktailById(cocktailId)
        return Cocktail(
            id = cocktailIngredientRoom.cocktail.id,
            name = cocktailIngredientRoom.cocktail.name,
            src = cocktailIngredientRoom.cocktail.src,
            ingredients = cocktailIngredientRoom.ingredients.map { it.asDomain() }
        )
    }

    override fun deleteCache() {
        dao.clearAllTables()
    }
}



