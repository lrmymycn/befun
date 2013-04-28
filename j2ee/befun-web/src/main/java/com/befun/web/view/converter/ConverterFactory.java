package com.befun.web.view.converter;

import java.util.HashMap;
import java.util.Map;

import com.befun.domain.BaseModel;
import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;

public class ConverterFactory {

    @SuppressWarnings("rawtypes")
    public static Map<Class, ViewConverter> cache = new HashMap<Class, ViewConverter>();

    static {
        cache.put(Media.class, new MediaConverter());
        cache.put(ProjectMedia.class, new ProjectMediaConverter());
        cache.put(Area.class, new AreaConverter());
        cache.put(Suburb.class, new SuburbConverter());
        cache.put(Project.class, new ProjectConverter());
        cache.put(Stage.class, new StageConverter());
        cache.put(Building.class, new BuildingConverter());
        cache.put(Floorplan.class, new FloorplanConverter());
        cache.put(Apartment.class, new ApartmentConverter());
    }

    @SuppressWarnings("unchecked")
    public static <M extends BaseModel<?>, VC extends ViewConverter<?, ?>> VC getConverter(Class<M> modelClazz) {
        return (VC) cache.get(modelClazz);
    }

}
