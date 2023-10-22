package io.github.seujorgenochurras.assemble;

import io.github.seujorgenochurras.domain.Vote;
import io.github.seujorgenochurras.dto.VoteDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VoteAssembler {

    public Vote toEntity(VoteDto voteDto){
        return new ModelMapper().map(voteDto, Vote.class);
    }
}
