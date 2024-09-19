package org.example;

import com.profile.service.ProfileServiceGrpc;
import com.profile.service.ProfileServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class ProfileServiceImpl extends ProfileServiceGrpc.ProfileServiceImplBase {

    @Override
    public void profile(ProfileServiceOuterClass.ProfileRequest request, StreamObserver<ProfileServiceOuterClass.ProfileResponse> responseObserver) {
        ProfileServiceOuterClass.ProfileResponse response = ProfileServiceOuterClass.ProfileResponse.newBuilder()
                .setProfile(String.format("I'm %s, I'm %s y.o", request.getName(), request.getAge()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
