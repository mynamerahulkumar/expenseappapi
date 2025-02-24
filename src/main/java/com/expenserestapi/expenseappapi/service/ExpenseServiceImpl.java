package com.expenserestapi.expenseappapi.service;

import com.expenserestapi.expenseappapi.dto.ExpenseDTO;
import com.expenserestapi.expenseappapi.entity.ExpenseEntity;
import com.expenserestapi.expenseappapi.exception.ResourceNotFoundException;
import com.expenserestapi.expenseappapi.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
//@RequiredArgsConstructor// it will create constructor of repo and model
@Slf4j
public class ExpenseServiceImpl  implements  ExpenseService{

    private  ExpenseRepository expenseRepository;

    private   ModelMapper modelMapper;

    /**
     *
     * @return
     */

    @Override
    public List<ExpenseDTO> getAllExpense() {
        List<ExpenseEntity> expenseEntitieslist=expenseRepository.findAll();
        log.info("");
        List<ExpenseDTO> expenseDTOList=expenseEntitieslist.stream().map(
                expenseEntity -> mapExpenseDTO(expenseEntity)).collect(Collectors.toList());
        return expenseDTOList;
    }

    /**
     *
     * @param expenseId
     * @return
     */

    @Override
    public ExpenseDTO getExpenseById(String expenseId) {
         ExpenseEntity expenseEntityOptional=expenseRepository.findByExpenseId(expenseId)
                 .orElseThrow(()->new ResourceNotFoundException("Expense not found for the exepense id "+expenseId));
         return  mapExpenseDTO(expenseEntityOptional);
    }

    /**
     * delete by expense id
     * @param expenseId
     */
    @Override
    public void deleteByExpenseId(String expenseId) {
        ExpenseEntity expenseEntity=expenseRepository.findByExpenseId(expenseId)
                .orElseThrow(()->new ResourceNotFoundException("ExpenseId not present"));
        expenseRepository.delete(expenseEntity);
    }

    /**
     * Save expense details to db
     * @param expenseDTO
     * @return
     */

    @Override
    public ExpenseDTO saveExpenseDetails(ExpenseDTO expenseDTO) {
         ExpenseEntity newExpenseEntity=mapExpenseDTO(expenseDTO);
         newExpenseEntity.setExpenseId(UUID.randomUUID().toString());
          newExpenseEntity=expenseRepository.save(newExpenseEntity);
          expenseDTO=mapExpenseDTO(newExpenseEntity);
          return expenseDTO;
    }

    private ExpenseEntity mapExpenseDTO(ExpenseDTO expenseDTO){
        return modelMapper.map(expenseDTO,ExpenseEntity.class);
    }
    /**
     *
     * @param expeseEntity
     * @return
     */
    public ExpenseDTO mapExpenseDTO(ExpenseEntity expeseEntity){
        return modelMapper.map(expeseEntity,ExpenseDTO.class);
    }
}
