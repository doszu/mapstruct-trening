package com.example.mapstruct;

import com.example.mapstruct.mapper.*;
import com.example.mapstruct.models.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

class MapstructApplicationTests {

    @Test
    public void example1TestMapping1() {

        Example1 example1 = Example1.builder()
                .title("Testing")
                .count(3)
                .type(Example1Enum.BLUE).build();

        Example1Dto example1Dto = Example1Mapper.INSTANCE.toExampleDto(example1);

        assertThat(example1Dto).isNotNull();
        assertThat(example1Dto.getTitle()).isEqualTo("Testing");
        assertThat(example1Dto.getCounter()).isEqualTo(3);
        assertThat(example1Dto.getType()).isEqualTo("BLUE");
    }


    @Test
    public void example1TestMapping2() {

        Example1Dto example1Dto = Example1Dto.builder()
                .title("Testing")
                .counter(3)
                .type("BLUE").build();

        Example1 example1 = Example1Mapper.INSTANCE.toExampleEntity(example1Dto);

        assertThat(example1).isNotNull();
        assertThat(example1.getTitle()).isEqualTo("Testing");
        assertThat(example1.getCount()).isEqualTo(3);
        assertThat(example1.getType()).isEqualTo(Example1Enum.BLUE);
    }


    @Test
    public void example2TestMapping() {

        Example1 example1 = Example1.builder()
                .title("Testing")
                .count(3)
                .type(Example1Enum.BLUE).build();

        Example1Dto example1Dto = Example2Mapper.INSTANCE.toExampleDtoCustom(example1);

        assertThat(example1Dto).isNotNull();
        assertThat(example1Dto.getTitle()).isEqualTo("Testing");
        assertThat(example1Dto.getCounter()).isEqualTo(3);
        assertThat(example1Dto.getType()).isEqualTo("B");
    }

    @Test
    public void example3TestMapping() {
        Example3_1 example3_1 = Example3_1.builder()
                .example("example test")
                .build();
        Example3_3 example3_3 = Example3_3.builder()
                .customer("test customer")
                .build();
        Example3_2 example3_2 = Example3_2.builder()
                .longer((long) 2)
                .example3_3(example3_3)
                .build();
        List<Example3_2> example3_2List = new ArrayList<>();
        example3_2List.add(example3_2);

        Example3 example = Example3.builder()
                .title("Test")
                .example3_1(example3_1)
                .example3_2List(example3_2List).build();

        Example3 copyExample = Example3Mapper.INSTANCE.copyExample2Dto(example);

        assertThat(copyExample.getTitle()).isEqualTo("Test");
        assertThat(copyExample.getExample3_1().getExample()).isEqualTo("example test");
        assertThat(copyExample.getExample3_2List())
                .extracting("longer", "example2_3.customer")
                .containsExactly(tuple((long) 2, "test customer"));
    }

    @Test
    public void example4TestMappingExisting() {

        Map<String, Object> map = new HashMap<>();
        map.put("ip", "127.0.0.1");
        map.put("server", "168.192.1.1");

        Example4Source s = Example4Source.builder()
                .map(map)
                .build();
        Example4Target t = Example4Mapper.MAPPER.toTarget(s);

        assertEquals(t.getIp(), "127.0.0.1");
        assertEquals(t.getServer(), "168.192.1.1");

    }

    @Test
    public void example4TestMappingNotExisting() {

        Map<String, Object> map = new HashMap<>();
        Example4Source s = Example4Source.builder()
                .map(map)
                .build();
        Example4Target t = Example4Mapper.MAPPER.toTarget(s);

        assertNull(t.getIp());
        assertNull(t.getServer());

    }

    @Test
    public void example5TestMapping() {

        Example5Source s = Example5Source.builder().build();
        s.setMyIntegers(Arrays.asList(5, 3, 7));
        s.setMyStrings(Arrays.asList("five", "three", "seven"));

        Example5Target t = Example5Mapper.MAPPER.toTarget(s);
        assertEquals(Integer.valueOf(5), t.getMyInteger());
        assertEquals("seven", t.getMyString());
    }
}
