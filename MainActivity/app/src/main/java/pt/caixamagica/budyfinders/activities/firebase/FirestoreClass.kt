package pt.caixamagica.budyfinders.activities.firebase

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import pt.caixamagica.budyfinders.activities.SignInActivity
import pt.caixamagica.budyfinders.activities.SignUpActivity
import pt.caixamagica.budyfinders.models.User
import pt.caixamagica.budyfinders.utils.Constants

class FirestoreClass {
    fun getCurrentUserID(): String {
        var currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if(currentUser != null){
            currentUserID = currentUser.uid
        }
        return currentUserID
    }

    fun registerUser(activity: SignUpActivity, user: User) {
        mFirestore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .set(user, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }
            .addOnFailureListener {
                exception ->
                Log.e(activity.javaClass.simpleName, "Fail creating",exception)
            }

    }

    fun loadUserData(activity: Activity) {
        mFirestore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)!!
                when(activity){
                    is SignInActivity -> {
                        activity.signInSuccess(loggedInUser)
                    }
                }
            }.addOnFailureListener { e ->
                when(activity){
                    is SignInActivity -> {
                        activity.hideProgressDialog()
                    }

                }
                Log.e(activity.javaClass.simpleName,"Error writing",e)
            }

    }

    private val mFirestore = FirebaseFirestore.getInstance()
}