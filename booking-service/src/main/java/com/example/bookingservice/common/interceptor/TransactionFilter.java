package com.example.bookingservice.common.interceptor;

import com.example.bookingservice.common.scope.RequestHeader;
import com.example.bookingservice.common.scope.RequestHeaderScope;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.example.bookingservice.common.constants.HeaderConstants.HEADER_LANGUAGE;
import static com.example.bookingservice.common.constants.HeaderConstants.HEADER_USER_ID;

@Slf4j
@Order(1)
@Component
@RequiredArgsConstructor
@WebFilter(filterName = "transactionFilter")
public class TransactionFilter extends OncePerRequestFilter {

    private final RequestHeaderScope requestHeaderScope;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            RequestHeader requestHeader = fillRequestHeader(request);
            requestHeaderScope.setRequestHeader(requestHeader);
        } catch (Exception e) {
            log.error("Transaction Filter exception " + e.getMessage(), e);
        }
        filterChain.doFilter(request,response);
    }

    private RequestHeader fillRequestHeader(HttpServletRequest request) {
        return RequestHeader.builder()
                .language(request.getHeader(HEADER_LANGUAGE))
                .userId(request.getHeader(HEADER_USER_ID))
                .build();
    }

}
