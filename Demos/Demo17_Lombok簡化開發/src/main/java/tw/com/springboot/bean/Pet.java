package tw.com.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 寵物
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {
    private String name;

//    public Pet() {
//    }
//
//    public Pet(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Pet{" +
//                "name='" + name + '\'' +
//                '}';
//    }
}
