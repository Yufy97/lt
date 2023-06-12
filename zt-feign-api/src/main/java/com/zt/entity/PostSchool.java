package entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (PostSchool)表实体类
 *
 * @author makejava
 * @since 2023-06-12 11:29:13
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSchool {
    
    private Long id;
    
    private Long postId;
    
    private String schoolName;

}

