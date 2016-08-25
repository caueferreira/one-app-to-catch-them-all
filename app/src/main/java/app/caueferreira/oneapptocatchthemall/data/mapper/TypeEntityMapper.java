package app.caueferreira.oneapptocatchthemall.data.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import app.caueferreira.oneapptocatchthemall.data.entity.TypeEntity;
import app.caueferreira.oneapptocatchthemall.domain.entity.Type;

/**
 * Created by caueferreira on 8/25/16.
 */

@Singleton
public class TypeEntityMapper {

    @Inject
    public TypeEntityMapper() {
    }

    public Type transform(final TypeEntity typeEntity) {

        return Type.create()
                .withName(typeEntity.getType().getName());
    }

    public List<Type> transform(final List<TypeEntity> typeEntities) {
        List<Type> typeList = new ArrayList<>();

        for (TypeEntity typeEntity : typeEntities)
            typeList.add(transform(typeEntity));

        return typeList;
    }
}
