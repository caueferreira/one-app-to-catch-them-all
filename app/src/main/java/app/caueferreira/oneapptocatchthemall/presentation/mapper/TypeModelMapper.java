package app.caueferreira.oneapptocatchthemall.presentation.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.domain.entity.Type;
import app.caueferreira.oneapptocatchthemall.presentation.model.TypeModel;

/**
 * Created by caueferreira on 8/29/16.
 */

@Singleton
public class TypeModelMapper {

    @Inject
    public TypeModelMapper() {
    }

    public TypeModel transform(final Type type) {

        return TypeModel.create()
                .withName(type.getName());
    }

    public List<TypeModel> transform(final List<Type> typeList) {
        List<TypeModel> typeModelList = new ArrayList<>();

        for (Type type : typeList)
            typeModelList.add(transform(type));

        return typeModelList;
    }
}
