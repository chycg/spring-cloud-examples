package com.neo.remote;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<HelloRemote> {
    @Override
    public HelloRemote create(Throwable throwable) {
        return (name) -> name + ": feign + hystrix ,提供者服务挂了";
    }
}