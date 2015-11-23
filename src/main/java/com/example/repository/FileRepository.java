package com.example.repository;

import com.example.model.FileObject;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Knight of k9 on 23/11/2015.
 */
public interface FileRepository extends CrudRepository <FileObject,Long>
{

}
