import com.github.davidfantasy.mybatisplus.generatorui.GeneratorConfig;
import com.github.davidfantasy.mybatisplus.generatorui.MybatisPlusToolsApplication;

/**
 * @ClassName GeneratorUIServer
 * @Description 生成兼容mybatis-plus框架的交互式网页生成器类
 * @Author songbaicheng
 * @Date 2023/6/12 16:30
 */
public class GeneratorUIServer {
    public static void main(String[] args) {
        GeneratorConfig config = GeneratorConfig.builder()
                .jdbcUrl("jdbc:mysql://localhost:3306/mall-admin")
                .userName("root")
                .password("songbaicheng")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .port(8068)
                .build();

        MybatisPlusToolsApplication.run(config);
    }
}
