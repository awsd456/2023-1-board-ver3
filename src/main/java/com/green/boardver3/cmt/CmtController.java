package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.*;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
public class CmtController {

    private final CmtService service;


    @Autowired
    public CmtController(CmtService service){
        this.service=service;
    }


    @PostMapping("/{iboard}/cmt")
    public int postCmt(@PathVariable int iboard,@RequestBody CmtInsDto dto){
        CmtEntity entity=new CmtEntity();
        entity.setIboard(iboard);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
     //   return service.insCmt(dto);
    return service.insCmt(entity);
    }


    @GetMapping("/{iboard}/cmt")
    public CmtRes getCmt(@PathVariable int iboard, @RequestParam int page, @RequestParam(defaultValue = "5") int row){
        CmtSelDto dto=new CmtSelDto();
        dto.setPage(page);
        dto.setLowRen(row);
        dto.setIboard(iboard);
        return service.selBoardCmt(dto);
    }


    @DeleteMapping("/cmt/{iboardCmt}")
    public int deleteBoardCmt(@PathVariable int iboardCmt,@RequestParam int iuser){
        CmtDelDto dto=new CmtDelDto();
        dto.setIboardCmt(iboardCmt);
        dto.setIuser(iuser);
        return service.delBoardCmt(dto);
    }

    @PutMapping("/cmt/{iboardCmt}")
    public int putBoardCmt(@PathVariable int iboardCmt,@RequestBody CmtUpdDto dto){
        CmtEntity entity=new CmtEntity();
        entity.setIboardCmt(iboardCmt);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.updBoardCmt(entity);
    }
}
