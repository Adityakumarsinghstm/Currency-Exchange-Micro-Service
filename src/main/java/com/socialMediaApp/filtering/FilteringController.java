package com.socialMediaApp.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;
import java.util.List;

import static com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.*;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering()
    {
        SomeBean someBean = new SomeBean("Value1","Value2","Value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBean",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList()
    {
        List<SomeBean> list = List.of(new SomeBean("Value4","Value5","Value6"),
                new SomeBean("Value7","Value8","Value9"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3","field5");
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBean",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
