package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.CertificateRequest;
import com.learnsphere.learnsphere.dto.CertificateResponse;
import com.learnsphere.learnsphere.entity.Certificate;
import org.springframework.stereotype.Component;

@Component
public class CertificateMapper implements Mapper<Certificate, CertificateRequest, CertificateResponse>{
    @Override
    public Certificate toEntity(CertificateRequest request) {
        Certificate certificate = new Certificate();
        certificate.setCertificateUrl(request.getCertificateUrl());
        certificate.setIssuedDate(request.getIssuedDate());
        certificate.setStudent(request.getStudent());
        certificate.setCourse(request.getCourse());
        return certificate;
    }

    @Override
    public CertificateResponse toResponse(Certificate certificate) {
        CertificateResponse response = new CertificateResponse();
        response.setId(certificate.getId());
        response.setCertificateUrl(certificate.getCertificateUrl());
        response.setIssuedDate(certificate.getIssuedDate());
        response.setStudent(certificate.getStudent());
        response.setCourse(certificate.getCourse());
        response.setCreatedAt(certificate.getCreatedAt());
        response.setUpdatedAt(certificate.getUpdatedAt());
        return null;
    }
}
