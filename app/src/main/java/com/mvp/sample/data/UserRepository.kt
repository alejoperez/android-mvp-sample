package com.mvp.sample.data


interface UserDataSource {
    fun getUser(): Any
    fun signIn()
}

class UserLocalDataSource : UserDataSource {
    override fun getUser(): Any = Any()
    override fun signIn() = throw UnsupportedOperationException()
}

class UserRemoteDataSource : UserDataSource {
    override fun getUser(): Any = Any()
    override fun signIn() {}
}

class UserRepository(private val localDataSource: UserDataSource = UserLocalDataSource(),
                     private val remoteDataSource: UserDataSource = UserRemoteDataSource()) : UserDataSource {

    override fun getUser(): Any = localDataSource.getUser()
    override fun signIn() = remoteDataSource.signIn()

}
