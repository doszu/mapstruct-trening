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

//EXAMPLE 1
    @Test
    public void example1TestMapping1() {

        Example1Source example1Source = Example1Source.builder()
                .title("Testing")
                .count(3)
                .type(Example1Enum.BLUE)
                .propObj(Example1_1Source.builder().prop("prop testing").build())
                .build();

        Example1Target example1Target = Example1Mapper.INSTANCE.toExampleDto(example1Source);

        assertThat(example1Target).isNotNull();
        assertThat(example1Target.getTitle()).isEqualTo("Testing");
        assertThat(example1Target.getCounter()).isEqualTo(3);
        assertThat(example1Target.getType()).isEqualTo("BLUE");
        assertThat(example1Target.getPropField()).isEqualTo("prop testing");
    }

    @Test
    public void example1TestMapping2() {

        Example1Target example1Target = Example1Target.builder()
                .title("Testing")
                .counter(3)
                .type("BLUE")
                .propField("prop field testing")
                .build();

        Example1Source example1Source = Example1Mapper.INSTANCE.toExampleEntity(example1Target);

        assertThat(example1Source).isNotNull();
        assertThat(example1Source.getTitle()).isEqualTo("Testing");
        assertThat(example1Source.getCount()).isEqualTo(3);
        assertThat(example1Source.getType()).isEqualTo(Example1Enum.BLUE);
        assertThat(example1Source.getPropObj().getProp()).isEqualTo("prop field testing");

    }

//EXAMPLE 2
    @Test
    public void example2TestMapping() {

        Example2Source s = Example2Source.builder().build();
        s.setMyIntegers(Arrays.asList(5, 3, 7));
        s.setMyStrings(Arrays.asList("five", "three", "seven"));

        Example2Target t = Example2Mapper.MAPPER.toTarget(s);
        assertEquals(Integer.valueOf(5), t.getMyInteger());
        assertEquals("seven", t.getMyString());
    }

//EXAMPLE 3
    @Test
    public void example3TestMappingExisting() {

        Map<String, Object> map = new HashMap<>();
        map.put("ip", "127.0.0.1");
        map.put("server", "168.192.1.1");

        Example3Source s = Example3Source.builder()
                .map(map)
                .build();
        Example3Target t = Example3Mapper.MAPPER.toTarget(s);

        assertEquals(t.getIp(), "127.0.0.1");
        assertEquals(t.getServer(), "168.192.1.1");

    }

    @Test
    public void example3TestMappingNotExisting() {

        Map<String, Object> map = new HashMap<>();
        Example3Source s = Example3Source.builder()
                .map(map)
                .build();
        Example3Target t = Example3Mapper.MAPPER.toTarget(s);

        assertNull(t.getIp());
        assertNull(t.getServer());

    }

//EXAMPLE 4
    @Test
    public void example4TestMapping() {

        Example1Source example1Source = Example1Source.builder()
                .title("Testing")
                .count(3)
                .type(Example1Enum.BLUE).build();

        Example1Target example1Target = Example4Mapper.INSTANCE.toExampleDtoCustom(example1Source);

        assertThat(example1Target).isNotNull();
        assertThat(example1Target.getTitle()).isEqualTo("Testing");
        assertThat(example1Target.getCounter()).isEqualTo(3);
        assertThat(example1Target.getType()).isEqualTo("B");
    }

//EXAMPLE 5
    @Test
    public void example5TestMapping() {

        Example5_1Source props = Example5_1Source.builder()
                .prop1("prop1")
                .prop2("prop2")
                .prop3("prop3")
                .build();
        Example5Source example5 = Example5Source.builder()
                .title("Testing")
                .props(props).build();

        Example5Target example5Target = Example5Mapper.INSTANCE.toTarget(example5);

        assertThat(example5Target).isNotNull();
        assertThat(example5Target.getProp1()).isEqualTo("prop1");
        assertThat(example5Target.getProp2()).isEqualTo("prop2");
        assertThat(example5Target.getProp3()).isEqualTo("prop3");

        System.out.println(example5Target);
    }


    @Test
    public void example5TestMapping2() {
        Example5Target example5 = Example5Target.builder()
                .prop1("prop1")
                .prop2("prop2")
                .prop3("prop3")
                .build();

        Example5Source example5Source = Example5Mapper.INSTANCE.toSource(example5);

        assertThat(example5Source).isNotNull();
        assertThat(example5Source.getProps().getProp1()).isEqualTo("prop1");
        assertThat(example5Source.getProps().getProp2()).isEqualTo("prop2");
        assertThat(example5Source.getProps().getProp3()).isEqualTo("prop3");

        System.out.println(example5Source);
    }

//EXAMPLE 6
    @Test
    public void example6TestMapping() {
        Example6_1 example6_1 = Example6_1.builder()
                .example("example test")
                .build();
        Example6_3 example6_3 = Example6_3.builder()
                .customer("test customer")
                .build();
        Example6_2 example6_2 = Example6_2.builder()
                .longer((long) 2)
                .example6_3(example6_3)
                .build();
        List<Example6_2> example6_2List = new ArrayList<>();
        example6_2List.add(example6_2);

        Example6 example = Example6.builder()
                .title("Test")
                .example6_1(example6_1)
                .example6_2List(example6_2List).build();

        Example6 copyExample = Example6Mapper.INSTANCE.copyExample6Dto(example);

        assertThat(copyExample.getTitle()).isEqualTo("Test");
        assertThat(copyExample.getExample6_1().getExample()).isEqualTo("example test");
        assertThat(copyExample.getExample6_2List())
                .extracting("longer", "example6_3.customer")
                .containsExactly(tuple((long) 2, "test customer"));
    }
}
