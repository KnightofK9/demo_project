package com.example.repository;

import com.example.model.FileObject;
import com.example.model.ImgObject;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Knight of k9 on 23/11/2015.
 */
public interface ImgRepository extends CrudRepository <ImgObject,Long>
{

}
