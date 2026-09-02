package MybatisDemo1;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAll(){
        return studentMapper.findAll();
    }
    public Student findById(Integer id){
        return studentMapper.findById(id);
    }
    public int insert(Student student){
        return studentMapper.insert(student);
    }
    public int update(Student student){
        return studentMapper.update(student);
    }
    public int deleteById(Integer id){
        return studentMapper.deleteById(id);
    }
    public List<Student> search( String name, Integer score){
        return studentMapper.search(name,score);
    }
}
