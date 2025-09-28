import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.example.myapplication.domain.entities.Dice
import com.example.myapplication.domain.models.ChampionCreationState

class ClassicAttributeRollingViewModel {
    private val TAG = "ClassicAttributeRollingViewModel"
    var strength by mutableIntStateOf(0)
    var dexterity by mutableIntStateOf(0)
    var constitution by mutableIntStateOf(0)
    var intelligence by mutableIntStateOf(0)
    var wisdom by mutableIntStateOf(0)
    var charism by mutableIntStateOf(0)

    fun rollTheDices() {
        val attributes = Dice.roll3d6()

        strength = attributes[0]
        dexterity = attributes[1]
        constitution = attributes[2]
        intelligence = attributes[3]
        wisdom = attributes[4]
        charism = attributes[5]
    }

    fun setAttributesAndMoveNext(onNavigateToRaceSelectionScreen: () -> Unit) {
        val championCreationState = ChampionCreationState.getInstance()
        championCreationState.strength = strength
        championCreationState.dexterity = dexterity
        championCreationState.constitution = constitution
        championCreationState.intelligence = intelligence
        championCreationState.wisdom = wisdom
        championCreationState.charism = charism

        Log.d(TAG, "selected attributes -> " +
                "str: [${championCreationState.strength}] " +
                "dex: [${championCreationState.dexterity}] " +
                "con: [${championCreationState.constitution}] " +
                "int: [${championCreationState.intelligence}] " +
                "wis: [${championCreationState.wisdom}] " +
                "cha: [${championCreationState.charism}] " +
                "")

        onNavigateToRaceSelectionScreen()
    }
}