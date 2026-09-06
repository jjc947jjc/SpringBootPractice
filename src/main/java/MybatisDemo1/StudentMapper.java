package MybatisDemo1;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student ")
    List<Student> findAll();
    @Select("SELECT * FROM student WHERE id =#{id}")
    Student findById(Integer id);
    @Insert("INSERT INTO student VALUES (#{id},#{name},#{gender},#{classId},#{score})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);
    @Update("UPDATE student SET name=#{name},gender=#{gender},class_id=#{classId},score=#{score} WHERE id=#{id}")
    int update(Student student);
    @Delete("DELETE FROM student WHERE id=#{id}")
    int deleteById(Integer id);
    @Select("<script>"+
            "SELECT * FROM student "+
            "<where>"+
            "<if test ='name!=null'> AND name LIKE CONCAT('%',#{name},'%')</if>"+
            "<if test ='id!=null'> AND id =#{id}</if>"+
            "</where>"+
            "</script>")
    List<Student> search(String name,Integer id);
    @Select("SELECT COUNT(*) FROM admin WHERE username=#{username} AND password =#{password}")
    int login(Manager manager);
}
