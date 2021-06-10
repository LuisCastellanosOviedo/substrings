package com.appgate.substr;

import com.appgate.substr.model.CombinatorRequest;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class SubStrHandler  extends SpringBootRequestHandler<CombinatorRequest, Integer> {
}
