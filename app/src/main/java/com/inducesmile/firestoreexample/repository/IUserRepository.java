package com.inducesmile.firestoreexample.repository;

import com.inducesmile.firestoreexample.FirestoreUserModel;

public interface IUserRepository {

    void doesUserEmailExist(String email);

    void addNewRegisteredUser(FirestoreUserModel firestoreUserModel);
}
