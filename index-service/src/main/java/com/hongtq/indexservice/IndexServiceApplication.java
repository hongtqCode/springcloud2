package com.hongtq.indexservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient	//注册服务客户端
@EnableFeignClients	//用feign客户端rest调用
@EnableCircuitBreaker //引入熔断机制
@EnableHystrixDashboard //引入熔断监控器
public class IndexServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndexServiceApplication.class, args);
	}

}
