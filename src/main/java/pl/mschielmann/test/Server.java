package pl.mschielmann.test;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import pl.mschielmann.test.TestGrpcServiceGrpc.TestGrpcServiceImplBase;
import pl.mschielmann.test.TestProtos.SendTestMessageRequest;
import pl.mschielmann.test.TestProtos.SendTestMessageResponse;

@GrpcService
public class Server extends TestGrpcServiceImplBase {

    @Override
    public void sendTestMessage(SendTestMessageRequest request, StreamObserver<SendTestMessageResponse> response) {
        System.out.println("Received request: " + request.getMessage());
        response.onNext(SendTestMessageResponse.newBuilder().setMessage(request.getMessage()).build());
        response.onCompleted();
    }
}
