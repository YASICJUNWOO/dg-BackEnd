package com.example.dgbackend.domain.member.service;

import com.example.dgbackend.domain.member.dto.MemberRequestDTO;
import com.example.dgbackend.domain.member.dto.MemberResponseDTO;

public interface MemberCommandService {
    MemberResponseDTO.RecommendInfoDTO patchRecommendInfo(Long memberID, MemberRequestDTO.RecommendInfoDTO recommendInfoDTO);
}
