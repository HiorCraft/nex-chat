package de.hiorcraft.nex.nexchat.deathmessages

import dev.slne.surf.surfapi.core.api.messages.Colors
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.builder.SurfComponentBuilder
import dev.slne.surf.surfapi.core.api.util.mutableObject2ObjectMapOf
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextReplacementConfig
import org.bukkit.entity.*
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDamageEvent.DamageCause
import kotlin.reflect.KClass

object DeathMessageProvider {

    private const val PLAYER_PLACEHOLDER = "<player>"
    private const val KILLER_PLACEHOLDER = "<killer>"

    private val genericMessages = mutableObject2ObjectMapOf<DamageCause, List<Component>>(
        EntityDamageEvent.DamageCause.FALL to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" boden war da!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" hat den Boden gefunden.")
            }
        ),
        EntityDamageEvent.DamageCause.VOID to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" fällt nun für immer.")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" ist das end hier?")
            }
        ),
        EntityDamageEvent.DamageCause.THORNS to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" die rüstung tut weh.")
            }
        ),
        EntityDamageEvent.DamageCause.SUICIDE to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wollte nicht mehr leben!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" hat sich das leben genommen!")
            }
        ),
        EntityDamageEvent.DamageCause.SUFFOCATION to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde lebendig begraben!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" muss nicht mehr begraben werden.")
            }
        ),
        EntityDamageEvent.DamageCause.STARVATION to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" ist verhungert!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" nächste mal was essen.")
            }
        ),
        EntityDamageEvent.DamageCause.POISON to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" das esse war nicht mehr gut!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" starb an einer Vergiftung!")
            }
        ),
        EntityDamageEvent.DamageCause.MAGIC to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" Magie ist leider nicht mehr gut!")
            }
        ),
        EntityDamageEvent.DamageCause.LIGHTNING to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde vom Blitz erschlagen!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" Gott hat nein gesagt.")
            }
        ),
        EntityDamageEvent.DamageCause.LAVA to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" verwechselte mit Wasser.")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" ging in Flammen auf!")
            }
        ),
        EntityDamageEvent.DamageCause.FIRE_TICK to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" ist nur schwarz noch!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" muss nicht mehr begraben werden.")
            }
        ),
        EntityDamageEvent.DamageCause.DROWNING to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" war leider kein Fisch.")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" könnte nicht schwimmen!")
            }
        ),
        EntityDamageEvent.DamageCause.CRAMMING to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde in der Masse zerdrückt!")
            }
        ),
        EntityDamageEvent.DamageCause.DRAGON_BREATH to listOf(
            buildText {
                spacer("Ein Drache hat")
                spacer(PLAYER_PLACEHOLDER)
                spacer(" geröstet")
            }
        ),
        EntityDamageEvent.DamageCause.CONTACT to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wure zu Tode gestochen!")
            }
        ),
        EntityDamageEvent.DamageCause.FREEZE to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" ist eingefroren")
            }
        ),
        EntityDamageEvent.DamageCause.WITHER to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" ist innerlich zerbröselt.")
            }
        ),
        EntityDamageEvent.DamageCause.SONIC_BOOM to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde vom ein Laser gestorben.")
            }
        )
    )

    private val entityMessages = mutableObject2ObjectMapOf<KClass<out Entity>, List<Component>>(
        Creeper::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von ein Creeper zerfetzt!")
            },
            buildText {
                spacer(" Ein Creeper hat")
                spacer(PLAYER_PLACEHOLDER)
                spacer(" hochgejagt!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" war alleine im Wald")
            }
        ),
        Zombie::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wure von einem Zombie getötet!")
            },
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" War lecker (Zombie).")
            }
        ),
        Skeleton::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von einem Skeleton getötet!")
            }
        ),
        Wither::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde vom Wither getötet!")
            },
            buildText {
                spacer(" Wither 1")
                spacer(PLAYER_PLACEHOLDER + "0.")
            }
        ),
        WitherSkeleton::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde vom einem Wither Skelett.")
            }
        ),
        EnderDragon::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von einem Enderdragon.")
            }
        ),
        Player::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von ")
                spacer(KILLER_PLACEHOLDER)
                spacer(" gekill!")
            }
        ),
        Ghast::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von Ghast gestoffen!")
            }
        ),
        TNTPrimed::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" war keine Wunderkerze!")
            }
        ),
        Spider::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von einer Spinne erledigt!")
            }
        ),
        Wolf::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von einem Wolf erledigt!")
            }
        ),
        Blaze::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde in flammen gesetzt von Blaze.")
            }
        ),
        Bee::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" hatte eine Bienenallgie!")
            }
        ),
        Enderman::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" lieber nicht mit den großen anlegen.")
            }
        ),
        IronGolem::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von einem Eisengolem in Himmel geworfen.")
            }
        ),
        Ravager::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von einem Ravager gekill.")
            }
        ),
        Piglin::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" war pures Gold!")
            }
        ),
        Phantom::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" soll mehr schafen!Q")
            }
        ),
        Silverfish::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde versilbert!")
            }
        ),
        Hoglin::class to listOf(
            buildText {
                spacer(PLAYER_PLACEHOLDER)
                spacer(" wurde von einem zerstampft")
            }
        )
    )

    private val DEFAULT_MESSAGE = buildText {
        spacer(PLAYER_PLACEHOLDER)
        spacer(" ist gestorben")
    }

    private fun getMessage(cause: DamageCause?, killer: Entity?): Component {
        if (killer != null) {
            for (clazz in entityMessages.keys) {
                if (clazz.isInstance(killer)) {
                    val templates = entityMessages[clazz]
                    if (templates != null && templates.isNotEmpty()) return templates.random()
                }
            }
        }

        return genericMessages[cause]?.random() ?: DEFAULT_MESSAGE
    }

    fun getDeathMessageComponent(
        player: Player,
        cause: DamageCause?,
        killer: Entity?
    ): Component {
        var deathMessage = getMessage(cause, killer)
        deathMessage = deathMessage.replaceText(
            TextReplacementConfig.builder().matchLiteral(PLAYER_PLACEHOLDER).replacement(player.displayName()).build()
        )

        killer?.let { kr ->
            val killerName = when (kr) {
                is Player -> kr.displayName()
                else -> Component.translatable(kr.type.translationKey()).colorIfAbsent(Colors.VARIABLE_VALUE)
            }
            deathMessage = deathMessage.replaceText(
                TextReplacementConfig.builder().matchLiteral(KILLER_PLACEHOLDER).replacement(killerName).build()
            )
        }

        return deathMessage
    }

    private fun SurfComponentBuilder.appendDeathPrefix() = append {
        spacer("[")
        error("💀")
        spacer("]")
        appendSpace()
    }
}