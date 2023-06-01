package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {

    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insCmt(CmtEntity entity) {

        try {
            int result = mapper.insCmt(entity);
            if (result == 1) {
                return entity.getIboardCmt();
            }
            return result;
        } catch (Exception e) {
        e.printStackTrace();
        }
        return 0;
    }


    public CmtRes selBoardCmt(CmtSelDto dto){

      int startIdx=(dto.getPage()-1) * dto.getLowRen();
      dto.setStartIdx(startIdx);
      List<CmtVo> list=mapper.selBoardCmt(dto);

      int rowCnt = mapper.selBoardCmtRowCountByIBoard(dto.getIboard());
      int isMore;
        int maxPage = (int)Math.ceil((double)rowCnt / dto.getLowRen());
        if(dto.getPage()<=maxPage){
            isMore=1;
        }
        else{
            isMore=0;
        }

        return  CmtRes.builder()
                .maxPage(maxPage)
                .list(list)
                .isMore(isMore)
                .build();

    }

    public int delBoardCmt(CmtDelDto dto){
        return mapper.delBoardCmt(dto);
    }

    public int updBoardCmt(CmtEntity entity){
        return mapper.updBoardCmt(entity);
    }
}

