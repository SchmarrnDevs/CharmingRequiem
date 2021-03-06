/// Copyright 2022 Andreas Kohler
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package dev.schmarrn.charmingrequiem;

import ladysnake.requiem.api.v1.event.requiem.PossessionEvents;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import svenhjol.charm.api.event.PlayerDropInventoryCallback;

public class CharmingRequiem implements ModInitializer {
    public static final String MOD_ID = "charmingrequiem";
    public static final String MOD_NAME = "Charming Requiem";

    public static Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello from {}", MOD_NAME);

        PossessionEvents.HOST_DEATH.register(((player, host, deathCause) -> PlayerDropInventoryCallback.EVENT.invoker().interact(player, player.getInventory())));
    }
}
