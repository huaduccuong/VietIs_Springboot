package vn.co.vis.web.service.impl;

import org.springframework.stereotype.Service;
import vn.co.vis.web.dto.request.SharingFolderRequest;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.dto.response.SharingFolderResponse;
import vn.co.vis.web.service.AbstractService;
import vn.co.vis.web.service.SharingFolderService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
@Service
public class SharingFolderServiceImpl extends AbstractService implements SharingFolderService {
    @Override
    public Optional<SharingFolderResponse> getSharingFolder(HttpServletRequest httpServletRequest, String userId) {
        SharingFolderResponse response
                = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "sharing-folder", userId), SharingFolderResponse.class);
        if (response == null) {
            return Optional.empty();
        }
        return Optional.of(response);
    }

    @Override
    public Optional<SharingFolderResponse> insertSharingFolder(HttpServletRequest httpServletRequest, SharingFolderRequest sharingFolderRequest) {
        SharingFolderResponse response = apiExchangeService.post(httpServletRequest, backApiUrl + "/sharing-folder", sharingFolderRequest, SharingFolderResponse.class);
        return Optional.of(response);

    }
}
