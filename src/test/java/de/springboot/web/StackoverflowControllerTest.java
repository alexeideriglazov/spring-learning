package de.springboot.web;

import com.google.common.collect.ImmutableList;
import de.springboot.model.StackoverflowWebsite;
import de.springboot.service.StackoverflowService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class StackoverflowControllerTest {
    @InjectMocks
    StackoverflowController sut;

    @Mock
    private StackoverflowService stackoverflowService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    void getListProviders(){
        //prepare
        when(stackoverflowService.findAll()).thenReturn(ImmutableList.of());
        //testing
        List<StackoverflowWebsite> listOfProviders =  sut.getListProviders();
        //validate
        verify(stackoverflowService).findAll();
    }
}