package com.example.alibabanacosdiscoveryserver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Random;

@RestController
//@RequestMapping("/config")
@RefreshScope
public class TestController {


    public static void a(){
    }

    private static void b() {
    }

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    TestService testService;

    @GetMapping("/hello/{str}")
    public String hello2(@PathVariable("str") String str){
        return testService.hello(str);
    }


    @GetMapping("/hello2")
    public String hello2(){
        List<ServiceInstance> instances = discoveryClient.getInstances("spring-cloud-server");
        int index = new Random().nextInt(instances.size());
        String url = instances.get(index).getUri()+"/hello2?str="+"hello2";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        return "Invoke :"+url+",return :"+result;
    }



//    @Bean
//    @LoadBalanced
//    public WebClient.Builder loadBalancedWebClientBuilder(){
//        return WebClient.builder();
//    }
//
//    @Autowired
//    public WebClient.Builder webClientBuilder;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){
        String result = restTemplate.getForObject("http://spring-cloud-server/hello2?str=test",String.class);
        return "return :"+result;
    }

//    @RequestMapping("/test2")
//    public Mono<String> test2(){
//        Mono<String> result = webClientBuilder.build().get().uri("http://spring-cloud-server/hello?name=test2").retrieve().bodyToMono(String.class);
//        return  result;
//    }

    @Value("${title:}")
    private String title;

    @Value("${config.title:}")
    private String title2;

    @RequestMapping("/config/test")
    public String test22(){
        System.out.println("title="+title);
        System.out.println("title2="+title2);
        return title;
    }

    @Autowired
    SentinelResourceService sentinelResourceService;

    @RequestMapping("/message1")
    public String message(){
        return sentinelResourceService.message();
    }

    @RequestMapping("/message2")
    public String message2(){
        return sentinelResourceService.message();
    }
}
