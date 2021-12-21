package pl.mschielmann.test;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    /*
    This approach does not work (this is probably against documentation though, should be using @GrpcClientBean
    @Bean
    @GrpcClient("test-client")
    public TestGrpcServiceBlockingStub testService(TestGrpcServiceBlockingStub stub) {
        return stub;
    }
     */
}
