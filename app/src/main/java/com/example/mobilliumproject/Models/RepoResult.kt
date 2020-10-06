package com.example.mobilliumproject.Models


data class RepoResult(val type: String?,
                      val title: String?,
                      val featured:List<Featured>?,
                      val products: List<Product>?,
                      val categories: List<Category>?,
                      val collections: List<Collection>?,
                      val shops: List<ShopsEditor>?
) {

    data class Featured(
        val type: String?,
        val title: String?,
        val sub_title: String?,
        val id: Int?,
        val cover: Cover?
    ) {
        data class Cover(
            val height: Int?,
            val medium: Medium?,
            val thumbnail: Thumbnail?,
            val url: String?,
            val width: Int?
        ) {
            data class Medium(val height: Int?, val url: String?, val width: Int?)
            data class Thumbnail(val height: Int?, val url: String?, val width: Int?)
        }
    }
    data class Product(
        val title: String?,
        val stock: Int?,
        val slug: String?,
        val shop: Shop?,
        val share_url: String?,
        val reject_reason: String?,
        val price: Int?,
        val old_price: Int?,
        val max_installment: Int?,
        val like_count: Int?,
        val is_owner: Boolean?,
        val is_new: Boolean?,
        val is_liked: Boolean,
        val is_editor_choice: Boolean?,
        val is_cargo_free: Boolean?,
        val is_approved: Boolean?,
        val is_active: Boolean?,
        val images: List<Image>?,
        val id: Int?,
        val difference: String?,
        val definition: String?,
        val commission_rate: Int?,
        val comment_count: Int?,
        val code: String?,
        val category_id: Int?,
        val category: Category?,
        val cargo_time: Int?
    ) {

        data class Shop(
            val vacation_mode: Int?,
            val slug: String?,
            val shop_rate: Int,
            val shop_payment_id: Int?,
            val share_url: String?,
            val product_count: Int?,
            val name_updateable: Boolean?,
            val name: String?,
            val logo: Cover?,
            val is_following: Boolean?,
            val is_editor_choice: Boolean?,
            val id: Int?,
            val follower_count: Int?,
            val definition: String?,
            val created_at: String?,
            val cover: Cover?,
            val comment_count: Int?
        ) {
            data class Cover(
                val height: Int?,
                val medium: Medium?,
                val thumbnail: Thumbnail?,
                val url: String?,
                val width: Int?
            ) {
                data class Medium(val height: Int?, val url: String?, val width: Int?)
                data class Thumbnail(val height: Int?, val url: String?, val width: Int?)
            }
        }

        data class Image(
            val height: Int?,
            val medium: Medium?,
            val thumbnail: Thumbnail?,
            val url: String?,
            val width: Int?
        ) {
            data class Medium(val height: Int?, val url: String?, val width: Int?)
            data class Thumbnail(val height: Int?, val url: String?, val width: Int?)
        }

        data class Category(
            val id: Int?,
            val name: String?,
            val order: Int?,
            val parent_category: Parent_Category?,
            val parent_id: Int?
        ) {
            data class Parent_Category(
                val id: Int?,
                val name: String?,
                val order: Int?,
                val parent_category: Parent_Category?,
                val parent_id: Int?
            )
        }
    }
    data class Category(
        val id: Int?,
        val parent_id: Int?,
        var parent_category: Parent_Category?,
        val order: Int?,
        val name: String?,
        val logo: Cover?,
        val cover: Cover?,
        val children: List<Category>?
    ) {
        data class Parent_Category(
            val id: Int?,
            val name: String?,
            val order: Int?,
            val parent_category: Parent_Category?,
            val parent_id: Int?
        )

        data class Cover(
            val height: Int?,
            val medium: Medium?,
            val thumbnail: Thumbnail?,
            val url: String?,
            val width: Int?
        ) {
            data class Medium(val height: Int?, val url: String?, val width: Int?)
            data class Thumbnail(val height: Int?, val url: String?, val width: Int?)
        }
    }

    data class Collection(
        val title: String?,
        val start: String?,
        val share_url: String?,
        val logo: Cover?,
        val id: Int?,
        val end: String?,
        val definition: String?,
        val cover: Cover?
    ) {
        data class Cover(
            val height: Int?,
            val medium: Medium?,
            val thumbnail: Thumbnail?,
            val url: String?,
            val width: Int?
        ) {
            data class Medium(val height: Int?, val url: String?, val width: Int?)
            data class Thumbnail(val height: Int?, val url: String?, val width: Int?)
        }
    }

    data class ShopsEditor(
        val vacation_mode: Int?,
        val slug: String?,
        val shop_rate: Int?,
        val shop_payment_id: Int?,
        val share_url: String?,
        val product_count: Int?,
        val popular_products: List<Popular_Product>?,
        val name_updateable: Boolean?,
        val name: String?,
        val logo: Cover?,
        val is_following: Boolean?,
        val is_editor_choice: Boolean?,
        val id: Int?,
        val follower_count: Int?,
        val definition: String?,
        val created_at: String?,
        val cover: Cover?,
        val comment_count: Int?
    ) {
        data class Popular_Product(
            val view_cout: Int?,
            val title: String?,
            val stock: Int?,
            val slug: String?,
            val shop: List<ShopsNewShop>?,
            val share_url: String?,
            val reject_reason: String?,
            val price: Int?,
            val old_price: Int?,
            val max_installment: Int?,
            val like_count: Int?,
            val is_owner: Boolean?,
            val is_new: Boolean?,
            val is_liked: Boolean?,
            val is_editor_choice: Boolean?,
            val is_cargo_free: Boolean?,
            val is_approved: Boolean?,
            val is_active: Boolean?,
            val images: List<Image>?,
            val id: Int?,
            val difference: String?,
            val definition: String?,
            val commission_rate: Int?,
            val comment_count: Int?,
            val code: String?,
            val category_id: Int?,
            val category: Category?,
            val cargo_time: Int?
        ) {
            data class ShopsNewShop(
                val vacation_mode: Int?,
                val slug: String?,
                val shop_rate: Int?,
                val shop_payment_id: Int?,
                val share_url: String?,
                val product_count: Int?,
                val name_updateable: Boolean?,
                val name: String?,
                val logo: Cover?,
                val is_following: Boolean?,
                val is_editor_choice: Boolean?,
                val id: Int?,
                val follower_count: Int?,
                val definition: String?,
                val created_at: String?,
                val cover: Cover?,
                val comment_count: Int?
            ) {
                data class Cover(
                    val height: Int?,
                    val medium: Medium?,
                    val thumbnail: Thumbnail?,
                    val url: String?,
                    val width: Int?
                ) {
                    data class Thumbnail(val height: Int?, val url: String?, val width: Int?)
                    data class Medium(val height: Int?, val url: String?, val width: Int?)
                }
            }

            data class Category(
                val id: Int?,
                val name: String?,
                val order: Int?,
                val parent_category: Parent_Category?,
                val parent_id: Int?
            ) {
                data class Parent_Category(
                    val id: Int?,
                    val name: String?,
                    val order: Int?,
                    val parent_category: Parent_Category?,
                    val parent_id: Int?
                )
            }

            data class Image(
                val height: Int?,
                val medium: Medium?,
                val thumbnail: Thumbnail?,
                val url: String?,
                val width: Int?
            ) {
                data class Medium(val height: Int?, val url: String?, val width: Int?)
                data class Thumbnail(val height: Int?, val url: String?, val width: Int?)
            }
        }

        data class Cover(
            val height: Int?,
            val medium: Medium?,
            val thumbnail: Thumbnail?,
            val url: String?,
            val width: Int?
        ) {
            data class Medium(val height: Int?, val url: String?, val width: Int?)
            data class Thumbnail(val height: Int?, val url: String?, val width: Int?)
        }
    }
}
