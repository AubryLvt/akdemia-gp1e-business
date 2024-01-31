package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dto.basic.SubThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.SubThemeFullDTO;
import af.cmr.indyli.akademia.business.dto.full.ThemeFullDTO;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SubThemeServiceTest {

    @Resource(name = ConstsValues.ServiceKeys.THEME_SERVICE_KEY)
    private IThemeService themeService;

    @Resource(name = ConstsValues.ServiceKeys.SUB_THEME_SERVICE_KEY)
    private ISubThemeService subThemeService;
    private SubThemeFullDTO subThemeForAllTest = null;
    private ThemeFullDTO themeForAllTest = null;

    private Integer idSubThemeCreated = null;

    @BeforeEach
    void setUp() throws AkdemiaBusinessException {
        ThemeFullDTO theme = getSampleTheme();
        this.themeForAllTest = this.themeService.create(theme);

        SubThemeFullDTO subTheme = getSampleSubTheme();
        this.subThemeForAllTest = this.subThemeService.create(subTheme);

        assertNotNull(subTheme);
    }

    @Test
    void testCreate() throws AkdemiaBusinessException {
        SubThemeFullDTO subTheme = getSampleSubTheme();

        subTheme.setThemes(List.of(this.themeForAllTest));
        subTheme.setSubthemeTitle("Laravel framework");

        subTheme = this.subThemeService.create(subTheme);
        idSubThemeCreated = subTheme.getId();

        assertNotNull(subTheme);
    }

    @Test
    void testFindAll() {
        List<SubThemeBasicDTO> subThemes = this.subThemeService.findAll();

        assertEquals(1, subThemes.size());
    }

    @Test
    void testFindById() throws AkdemiaBusinessException {
        SubThemeFullDTO subTheme = this.subThemeService.findById(this.subThemeForAllTest.getId());

        assertNotNull(subTheme);
        assertEquals(this.subThemeForAllTest.getSubthemeTitle(), subTheme.getSubthemeTitle());
    }

    @Test
    void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
        SubThemeFullDTO subThemeToUpdate = getSampleSubTheme();
        String updateName = "Updated Name";

        subThemeToUpdate.setId(this.subThemeForAllTest.getId());
        subThemeToUpdate.setSubthemeTitle(updateName);

        SubThemeFullDTO updatedSubTheme = this.subThemeService.update(subThemeToUpdate);
        assertEquals(updateName, updatedSubTheme.getSubthemeTitle());
    }

    @Test
    void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
        this.themeService.deleteById(this.themeForAllTest.getId());

        assertNull(this.themeService.findById(this.themeForAllTest.getId()));
        this.themeForAllTest = null;
    }

    @AfterEach
    void rollback() throws AkdemiaBusinessException, AccessDeniedException {
        if (this.subThemeForAllTest != null) this.subThemeService.deleteById(this.subThemeForAllTest.getId());
        if (idSubThemeCreated != null) this.subThemeService.deleteById(idSubThemeCreated);
        if (this.themeForAllTest != null) this.themeService.deleteById(this.themeForAllTest.getId());

    }

    SubThemeFullDTO getSampleSubTheme() {
        SubThemeFullDTO subTheme = new SubThemeFullDTO();
        subTheme.setSubthemeTitle("Example SubTheme");
        subTheme.setDescription("Example subtheme description");
        subTheme.setCreationDate(new Date());
        subTheme.setUpdateDate(new Date());

        return subTheme;
    }

    ThemeFullDTO getSampleTheme() {
        ThemeFullDTO theme = new ThemeFullDTO();
        theme.setThemeTitle("Example Theme");
        theme.setDescription("Example theme description");
        theme.setCreationDate(new Date());

        return theme;
    }
}
