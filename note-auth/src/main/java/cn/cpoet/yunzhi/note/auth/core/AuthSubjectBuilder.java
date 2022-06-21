package cn.cpoet.yunzhi.note.auth.core;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;

/**
 * @author CPoet
 */
public class AuthSubjectBuilder {
    private final AuthSubject subject;

    public AuthSubjectBuilder() {
        subject = new AuthSubject();
    }

    public AuthSubjectBuilder withUid(long uid) {
        subject.setUid(uid);
        return this;
    }

    public AuthSubjectBuilder withGroupId(long groupId) {
        subject.setGroupId(groupId);
        return this;
    }

    public AuthSubjectBuilder withAccount(String account) {
        subject.setAccount(account);
        return this;
    }

    public AuthSubjectBuilder withRoles(Collection<String> roles) {
        subject.setRoles(CollectionUtils.isEmpty(roles) ? Collections.emptyList() : roles);
        return this;
    }

    public AuthSubjectBuilder withPermissions(Collection<String> permissions) {
        subject.setPermissions(CollectionUtils.isEmpty(permissions) ? Collections.emptyList() : permissions);
        return this;
    }

    public AuthSubject build() {
        return subject;
    }
}
