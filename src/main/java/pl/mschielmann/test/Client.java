package pl.mschielmann.test;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.mschielmann.test.TestGrpcServiceGrpc.TestGrpcServiceBlockingStub;
import pl.mschielmann.test.TestProtos.SendTestMessageRequest;
import pl.mschielmann.test.TestProtos.SendTestMessageResponse;


@Component
public class Client {

    @GrpcClient("localServer")
    private TestGrpcServiceBlockingStub testService;

    @Scheduled(fixedRate = 5000, initialDelay = 2000)
    public void callServer() {
        System.out.println("Sending request");
        SendTestMessageResponse response = testService.sendTestMessage(SendTestMessageRequest.newBuilder().setMessage("Hello, world!").build());
        System.out.println("Response: " + response.getMessage());
    }
}
