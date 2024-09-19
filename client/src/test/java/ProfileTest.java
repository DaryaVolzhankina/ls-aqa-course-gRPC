import com.profile.service.ProfileServiceOuterClass;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfileTest extends BaseGrpcTest{

    @Test
    void profileTest() {
        ProfileServiceOuterClass.ProfileRequest request = ProfileServiceOuterClass.ProfileRequest.newBuilder()
                                                                                                 .setName("Daria")
                                                                                                 .setAge("23")
                                                                                                 .build();

        ProfileServiceOuterClass.ProfileResponse response = blockingStub.profile(request);

        assertThat(response.getProfile()).isEqualTo("I'm Daria, I'm 23 y.o");
    }
}
