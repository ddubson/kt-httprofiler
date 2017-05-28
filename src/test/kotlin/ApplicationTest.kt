import com.ddubson.Application
import com.ddubson.profiler.Profiler
import com.ddubson.reporter.Reporter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito.verify

@RunWith(JUnitPlatform::class)
class ApplicationTest : Spek({
    describe("application") {
        val reporter: Reporter = mock()
        val profiler: Profiler = mock()
        val application: Application = Application(profiler, reporter)

        given("http profiler returns a Server header") {
            it("should report the type of Server found") {
                val target = "localhost:80"
                val identifiedServer = "Apache"

                whenever(profiler.getHeaders(target))
                        .thenReturn(hashMapOf("Server" to identifiedServer))

                application.run(target)

                verify(profiler).getHeaders(target)
                verify(reporter).printReport(identifiedServer)
            }
        }
    }
})