package pl.mschielmann.test;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.mschielmann.test.TestGrpcServiceGrpc.TestGrpcServiceBlockingStub;
import pl.mschielmann.test.TestProtos.SendTestMessageRequest;
import pl.mschielmann.test.TestProtos.SendTestMessageResponse;

@Component
public class Client {

    /*
    // This approach works fine on its own.
    @GrpcClient("test-client")
    private TestGrpcServiceBlockingStub testService;
    */

    // Not working approach - beans are not ready to be injected (when using @GrpcClientBean) or causing circular dependencies when using @Bean with @GrpcClient
    private final TestGrpcServiceBlockingStub testService;
    public Client(TestGrpcServiceBlockingStub testService) {
        this.testService = testService;
    }

    @Scheduled(fixedRate = 5000, initialDelay = 2000)
    public void callServer() {
        System.out.println("Sending request");
        SendTestMessageResponse response = testService.sendTestMessage(SendTestMessageRequest.newBuilder().setMessage("Hello, world!").build());
        System.out.println("Response: " + response.getMessage());
    }
}
