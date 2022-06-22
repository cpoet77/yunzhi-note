package cn.cpoet.yunzhi.note.comm.core;

import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Optional;

/**
 * @author CPoet
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReactiveRequestWrapper implements RequestWrapper {

    private final static RequestWrapper NONE = new ReactiveRequestWrapper(null);

    private final ServerHttpRequest request;

    @Override
    public boolean requesting() {
        return request != null;
    }

    @Override
    public String getRemoteAddr() {
        return Optional
            .ofNullable(request)
            .map(ServerHttpRequest::getRemoteAddress)
            .map(InetSocketAddress::getHostString)
            .orElse(null);
    }

    @Override
    public String getHeader(String name) {
        if (request == null) {
            return null;
        }
        HttpHeaders headers = request.getHeaders();
        List<String> list = headers.get(name);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public String getParameter(String name) {
        if (request == null) {
            return null;
        }
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        return queryParams.getFirst(name);
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, Object o) {

    }

    public static RequestWrapper wrapper(ServerHttpRequest request) {
        if (request == null) {
            return NONE;
        }
        return new ReactiveRequestWrapper(request);
    }
}
