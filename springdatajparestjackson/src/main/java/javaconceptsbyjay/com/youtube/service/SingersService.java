package javaconceptsbyjay.com.youtube.service;

import javaconceptsbyjay.com.youtube.entity.Singers;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SingersService {
    public Integer saveSingers(Singers singers);
    public void update(Singers singers);
    public void delete(Integer id);
    public Singers getOneSinger(Integer id);
    public boolean isAvailable(Integer id);

}
