package com.mvp.sample.data

import io.realm.RealmObject

class User(val id: String,
           val name: String,
           val email: String): RealmObject()

class Place(val id: String,
            val companyName: String,
            val address: String,
            val lat: Double,
            val lon: Double): RealmObject()


class Post(val userId: String,
            val id: String,
            val title: String,
            val body: String): RealmObject()


class Photo(val albumId: String,
            val id: String,
            val title: String,
            val url: String,
            val thumbnailUrl: String): RealmObject()
