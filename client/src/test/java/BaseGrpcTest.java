import com.profile.service.ProfileServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseGrpcTest {
    public ProfileServiceGrpc.ProfileServiceBlockingStub blockingStub;
    private ManagedChannel channel;

    @BeforeEach
    public void arrangeTestData() {
        channel = NettyChannelBuilder.forAddress("localhost", 50051)
                                     .usePlaintext()
                                     .build();
        blockingStub = ProfileServiceGrpc.newBlockingStub(channel);
    }

    @AfterEach
    public void closeChannel(){
        channel.shutdownNow();
    }
}
