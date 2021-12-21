package pl.mschielmann.test;

import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.client.inject.GrpcClientBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mschielmann.test.TestGrpcServiceGrpc.TestGrpcServiceBlockingStub;

@Configuration
@GrpcClientBean(clazz = TestGrpcServiceBlockingStub.class, beanName = ClientConfiguration2.TEST_CLIENT, client = @GrpcClient("test-client"))
public class ClientConfiguration2 {
    final static String TEST_CLIENT = "test-client";

    @Bean
    public TestGrpcServiceBlockingStub testService(TestGrpcServiceBlockingStub stub) {
        return stub;
    }
}
