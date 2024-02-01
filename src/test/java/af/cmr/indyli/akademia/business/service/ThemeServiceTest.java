package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dto.basic.ThemeBasicDTO;
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
public class ThemeServiceTest {

    @Resource(name = ConstsValues.ServiceKeys.THEME_SERVICE_KEY)
    private IThemeService themeService;
    private ThemeFullDTO themeForAllTest = null;

    private Integer idCreatedTheme = null;

    @BeforeEach
    void setUp() throws AkdemiaBusinessException {
        ThemeFullDTO theme = getSampleTheme();
        this.themeForAllTest = this.themeService.create(theme);

        System.out.println("ID CREATE... " + themeForAllTest.getId());

        assertNotNull(theme);
    }

    @Test
    void testCreate() throws AkdemiaBusinessException {
        ThemeFullDTO theme = getSampleTheme();
        theme.setThemeTitle("Language du web");
        theme = this.themeService.create(theme);
        idCreatedTheme = theme.getId();

        assertNotNull(theme);
    }

    @Test
    void testFindAll() {
        List<ThemeBasicDTO> themes = this.themeService.findAll();

        assertEquals(1, themes.size());
    }

    @Test
    void testFindById() throws AkdemiaBusinessException {
        ThemeFullDTO theme = this.themeService.findById(this.themeForAllTest.getId());
        assertNotNull(theme);
        assertEquals(this.themeForAllTest.getThemeTitle(), theme.getThemeTitle());
    }

    @Test
    void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
        ThemeFullDTO themeToUpdate = getSampleTheme();
        String updateName = "Updated Name";
        themeToUpdate.setId(this.themeForAllTest.getId());
        themeToUpdate.setThemeTitle(updateName);

        ThemeFullDTO updatedTheme = this.themeService.update(themeToUpdate);
        assertEquals(updateName, updatedTheme.getThemeTitle());
    }

    @Test
    void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
        this.themeService.deleteById(this.themeForAllTest.getId());

        assertNull(this.themeService.findById(this.themeForAllTest.getId()));
        themeForAllTest = null;
    }

    @AfterEach
    void rollback() throws AkdemiaBusinessException, AccessDeniedException {
        if (themeForAllTest != null) this.themeService.deleteById(this.themeForAllTest.getId());
        if (idCreatedTheme != null) this.themeService.deleteById(idCreatedTheme);
    }

    ThemeFullDTO getSampleTheme() {
        ThemeFullDTO theme = new ThemeFullDTO();
        theme.setThemeTitle("Example Theme");
        theme.setDescription("Example theme description");
        theme.setCreationDate(new Date());

        return theme;
    }
}
