package app.caueferreira.oneapptocatchthemall.presentation.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.domain.entity.Type;
import app.caueferreira.oneapptocatchthemall.presentation.model.response.TypeResponse;

/**
 * Created by caueferreira on 8/29/16.
 */

@Singleton
public class TypeModelMapper {

    @Inject
    public TypeModelMapper() {
    }

    public TypeResponse transform(final Type type) {

        return TypeResponse.create()
                .withName(type.getName());
    }

    public List<TypeResponse> transform(final List<Type> typeList) {
        List<TypeResponse> typeResponseList = new ArrayList<>();

        for (Type type : typeList)
            typeResponseList.add(transform(type));

        return typeResponseList;
    }
}
