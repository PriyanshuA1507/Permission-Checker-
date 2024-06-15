package com.example.permissionclassifier

object PermissionSafetyChecker {
    fun isPermissionSafe(category: String?, permission: String): Boolean {
        when (category) {
            "Action" -> return ActionCategoryPermissions.isSafePermission(permission)
            "Adventure" -> return AdventureCategoryPermissions.isSafePermission(permission)
            "Arcade" -> return ArcadeCategoryPermissions.isSafePermission(permission)
            "Art & Design" -> return ArtAndDesignCategoryPermissions.isSafePermission(permission)
            "Auto & Vehicles" -> return AutoAndVehiclesCategoryPermissions.isSafePermission(
                permission
            )

            "Beauty" -> return BeautyCategoryPermissions.isSafePermission(permission)
            "Board" -> return BoardCategoryPermissions.isSafePermission(permission)
            "Books & Reference" -> return BooksAndReferenceCategoryPermissions.isSafePermission(
                permission
            )

            "Business" -> return BusinessCategoryPermissions.isSafePermission(permission)
            "CARD" -> return CardCategoryPermissions.isSafePermission(permission)
            "Casino" -> return CasinoCategoryPermissions.isSafePermission(permission)
            "Casual" -> return CasualCategoryPermissions.isSafePermission(permission)
            "Comics" -> return ComicsCategoryPermissions.isSafePermission(permission)
            "Communication" -> return CommunicationCategoryPermissions.isSafePermission(permission)
            "Dating" -> return DatingCategoryPermissions.isSafePermission(permission)
            "Education" -> return EducationCategoryPermissions.isSafePermission(permission)
            "Educational" -> return EducationalCategoryPermissions.isSafePermission(permission)
            "Entertainment" -> return EntertainmentCategoryPermissions.isSafePermission(permission)
            "Events" -> return EventsCategoryPermissions.isSafePermission(permission)
            "Finance" -> return FinanceCategoryPermissions.isSafePermission(permission)
            "Food & Drink" -> return FoodAndDrinkCategoryPermissions.isSafePermission(permission)
            "Health & Fitness" -> return HealthAndFitnessCategoryPermissions.isSafePermission(
                permission
            )

            "House & Home" -> return HouseAndHomeCategoryPermissions.isSafePermission(permission)
            "Libraries & Demo" -> return LibrariesAndDemoCategoryPermissions.isSafePermission(
                permission
            )

            "Lifestyle" -> return LifestyleCategoryPermissions.isSafePermission(permission)
            "Maps & Navigation" -> return MapsAndNavigationCategoryPermissions.isSafePermission(
                permission
            )

            "Medical" -> return MedicalCategoryPermissions.isSafePermission(permission)
            "Music" -> return MusicCategoryPermissions.isSafePermission(permission)
            "Music & Audio" -> return MusicAndAudioCategoryPermissions.isSafePermission(permission)
            "News & Magazines" -> return NewsAndMagazinesCategoryPermissions.isSafePermission(
                permission
            )

            "Parenting" -> return ParentingCategoryPermissions.isSafePermission(permission)
            "Personalization" -> return PersonalizationCategoryPermissions.isSafePermission(
                permission
            )

            "Photography" -> return PhotographyCategoryPermissions.isSafePermission(permission)
            "Productivity" -> return ProductivityCategoryPermissions.isSafePermission(permission)
            "Puzzle" -> return PuzzleCategoryPermissions.isSafePermission(permission)
            "Racing" -> return RacingCategoryPermissions.isSafePermission(permission)
            "Role Playing" -> return RolePlayingCategoryPermissions.isSafePermission(permission)
            "Shopping" -> return ShoppingCategoryPermissions.isSafePermission(permission)
            "Simulation" -> return SimulationCategoryPermissions.isSafePermission(permission)
            "Social" -> return SocialCategoryPermissions.isSafePermission(permission)
            "Sports" -> return SportsCategoryPermissions.isSafePermission(permission)
            "Strategy" -> return StrategyCategoryPermissions.isSafePermission(permission)
            "Tools" -> return ToolsCategoryPermissions.isSafePermission(permission)
            "Travel & Local" -> return TravelAndLocalCategoryPermissions.isSafePermission(permission)
            "Trivia" -> return TriviaCategoryPermissions.isSafePermission(permission)
            "Video Players & Editors" -> return VideoPlayersAndEditorsCategoryPermissions.isSafePermission(
                permission
            )

            "Weather" -> return WeatherCategoryPermissions.isSafePermission(permission)
            "Word" -> return WordCategoryPermissions.isSafePermission(permission)
        }
        return false
    }
}

internal object MusicCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("RECORD_AUDIO") ||
                permission.contains("MODIFY_AUDIO_SETTINGS") ||
                permission.contains("CHANGE_WIFI_MULTICAST_STATE") ||
                permission.contains("CHECK_LICENSE")
    }
}

internal object ActionCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("CHANGE_WIFI_MULTICAST_STATE") ||
                permission.contains("CHECK_LICENSE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("MODIFY_AUDIO_SETTINGS") ||
                permission.contains("CONTENT_READ")
    }
}

internal object AdventureCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("CHANGE_WIFI_MULTICAST_STATE") ||
                permission.contains("CHECK_LICENSE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CONTENT_READ")
    }
}

internal object ArcadeCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("CHANGE_WIFI_MULTICAST_STATE") ||
                permission.contains("CHECK_LICENSE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CONTENT_READ")
    }
}

internal object ArtAndDesignCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("VIBRATE") ||
                permission.contains("CAMERA") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("SET_WALLPAPER")
    }
}

internal object AutoAndVehiclesCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("VIBRATE") ||
                permission.contains("CAMERA") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("BLUETOOTH_ADMIN") ||
                permission.contains("CALL_PRIVILEGED") ||
                permission.contains("READ_GSERVICES") ||
                permission.contains("HIDE_OVERLAY_WINDOWS") ||
                permission.contains("RECORD_AUDIO") ||
                permission.contains("NEARBY_WIFI_DEVICES") ||
                permission.contains("READ_CONTACTS")
    }
}

internal object BeautyCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("SET_WALLPAPER") ||
                permission.contains("CALL_PRIVILEGED") ||
                permission.contains("READ_GSERVICES") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("RECORD_AUDIO")
    }
}

internal object BoardCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("CHANGE_WIFI_MULTICAST_STATE")
    }
}

internal object BooksAndReferenceCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("READ_PHONE_STATE")
    }
}

internal object BusinessCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("RECORD_AUDIO")
    }
}

internal object CardCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("USE_CREDENTIALS") ||
                permission.contains("RECORD_AUDIO") ||
                permission.contains("GET_TASKS") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("DEVICE_POWER")
    }
}

internal object CasinoCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("NEARBY_WIFI_DEVICES") ||
                permission.contains("GET_TASKS") ||
                permission.contains("CHANGE_NETWORK_STATE")
    }
}

internal object CasualCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("CHANGE_WIFI_MULTICAST_STATE") ||
                permission.contains("GET_TASKS") ||
                permission.contains("CHANGE_NETWORK_STATE") ||
                permission.contains("CHECK_LICENSE") ||
                permission.contains("RECORD_AUDIO") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("MODIFY_AUDIO_SETTINGS") ||
                permission.contains("NEARBY_WIFI_DEVICES") ||
                permission.contains("READ_MY_DATA") ||
                permission.contains("SET_ALARM") ||
                permission.contains("HIDE_OVERLAY_WINDOWS") ||
                permission.contains("WRITE_EXTERNAL_STORAGE") ||
                permission.contains("READ_GSERVICES") ||
                permission.contains("INSTALL_SHORTCUT") ||
                permission.contains("USE_CREDENTIALS") ||
                permission.contains("WRITE_SETTINGS") ||
                permission.contains("WAKE_LOCK")
    }
}

internal object ComicsCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER")
    }
}

internal object CommunicationCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("RECORD_AUDIO") ||
                permission.contains("READ_CONTACTS") ||
                permission.contains("MODIFY_AUDIO_SETTINGS") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("CALL_PRIVILEGED") ||
                permission.contains("HIDE_OVERLAY_WINDOWS") ||
                permission.contains("WRITE_CONTACTS")
    }
}

internal object DatingCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("MODIFY_AUDIO_SETTINGS") ||
                permission.contains("RECORD_AUDIO") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("READ_GSERVICES") ||
                permission.contains("HIDE_OVERLAY_WINDOWS") ||
                permission.contains("READ_CONTACTS")
    }
}

internal object EducationCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") ||
                permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("MODIFY_AUDIO_SETTINGS") ||
                permission.contains("RECORD_AUDIO") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("READ_GSERVICES") ||
                permission.contains("HIDE_OVERLAY_WINDOWS") ||
                permission.contains("READ_CONTACTS") ||
                permission.contains("CALL_PRIVILEGED") ||
                permission.contains("WRITE_CALENDAR") ||
                permission.contains("READ_CALENDAR")
    }
}

internal object EducationalCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("MODIFY_AUDIO_SETTINGS") || permission.contains(
            "RECORD_AUDIO"
        ) || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains("HIDE_OVERLAY_WINDOWS") || permission.contains(
            "CHANGE_WIFI_MULTICAST_STATE"
        ) || permission.contains("CHECK_LICENSE") || permission.contains("GET_TASKS")
    }
}

internal object EntertainmentCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("RECORD_AUDIO")
    }
}

internal object EventsCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") ||
                permission.contains("CONTENT_READ") ||
                permission.contains("MANAGE_USB") ||
                permission.contains("DEVICE_POWER") ||
                permission.contains("VIBRATE") ||
                permission.contains("RESTART_PACKAGES") ||
                permission.contains("READ_WIFI_CREDENTIAL") ||
                permission.contains("ACCESS_FINE_LOCATION") ||
                permission.contains("CAMERA") ||
                permission.contains("ACCESS_COARSE_LOCATION") ||
                permission.contains("READ_PHONE_STATE") ||
                permission.contains("ACCOUNT_MANAGER") ||
                permission.contains("MODIFY_AUDIO_SETTINGS") ||
                permission.contains("RECORD_AUDIO") ||
                permission.contains("ACCESS_BLUETOOTH_SHARE") ||
                permission.contains("HIDE_OVERLAY_WINDOWS") ||
                permission.contains("CHECK_LICENSE") ||
                permission.contains("WRITE_CALENDAR") ||
                permission.contains("READ_CALENDAR") ||
                permission.contains("READ_GSERVICES") ||
                permission.contains("READ_CONTACTS") ||
                permission.contains("BLUETOOTH_ADMIN") ||
                permission.contains("WRITE_CONTACTS") ||
                permission.contains("FLASHLIGHT") ||
                permission.contains("CALL_PRIVILEGED") ||
                permission.contains("NEARBY_WIFI_DEVICES")
    }
}

internal object FinanceCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return (permission.contains("ACCESS_NETWORK_STATE")
                || permission.contains("READ_NETWORK_USAGE_HISTORY")
                || permission.contains("CONTENT_READ")
                || permission.contains("MANAGE_USB")
                || permission.contains("DEVICE_POWER")
                || permission.contains("VIBRATE")
                || permission.contains("RESTART_PACKAGES")
                || permission.contains("READ_WIFI_CREDENTIAL")
                || permission.contains("ACCESS_FINE_LOCATION")
                || permission.contains("CAMERA")
                || permission.contains("ACCESS_COARSE_LOCATION")
                || permission.contains("READ_PHONE_STATE")
                || permission.contains("ACCOUNT_MANAGER")
                || permission.contains("READ_CONTACTS"))
    }
}

internal object FoodAndDrinkCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return (permission.contains("ACCESS_NETWORK_STATE")
                || permission.contains("READ_NETWORK_USAGE_HISTORY")
                || permission.contains("CONTENT_READ")
                || permission.contains("MANAGE_USB")
                || permission.contains("DEVICE_POWER")
                || permission.contains("VIBRATE")
                || permission.contains("RESTART_PACKAGES")
                || permission.contains("READ_WIFI_CREDENTIAL")
                || permission.contains("ACCESS_FINE_LOCATION")
                || permission.contains("CAMERA")
                || permission.contains("ACCESS_COARSE_LOCATION")
                || permission.contains("READ_PHONE_STATE")
                || permission.contains("ACCOUNT_MANAGER")
                || permission.contains("READ_GSERVICES")
                || permission.contains("CALL_PRIVILEGED")
                || permission.contains("HIDE_OVERLAY_WINDOWS"))
    }
}

internal object HealthAndFitnessCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return (permission.contains("ACCESS_NETWORK_STATE")
                || permission.contains("READ_NETWORK_USAGE_HISTORY")
                || permission.contains("CONTENT_READ")
                || permission.contains("MANAGE_USB")
                || permission.contains("DEVICE_POWER")
                || permission.contains("VIBRATE")
                || permission.contains("RESTART_PACKAGES")
                || permission.contains("READ_WIFI_CREDENTIAL")
                || permission.contains("ACCESS_FINE_LOCATION")
                || permission.contains("CAMERA")
                || permission.contains("ACCESS_COARSE_LOCATION")
                || permission.contains("READ_PHONE_STATE")
                || permission.contains("ACCOUNT_MANAGER")
                || permission.contains("MODIFY_AUDIO_SETTINGS")
                || permission.contains("RECORD_AUDIO")
                || permission.contains("ACCESS_BLUETOOTH_SHARE")
                || permission.contains("HIDE_OVERLAY_WINDOWS")
                || permission.contains("CHECK_LICENSE")
                || permission.contains("WRITE_CALENDAR")
                || permission.contains("READ_CALENDAR")
                || permission.contains("READ_GSERVICES")
                || permission.contains("READ_CONTACTS")
                || permission.contains("BLUETOOTH_ADMIN")
                || permission.contains("CALL_PRIVILEGED")
                || permission.contains("NEARBY_WIFI_DEVICES"))
    }
}

internal object HouseAndHomeCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return (permission.contains("ACCESS_NETWORK_STATE")
                || permission.contains("READ_NETWORK_USAGE_HISTORY")
                || permission.contains("CONTENT_READ")
                || permission.contains("MANAGE_USB")
                || permission.contains("DEVICE_POWER")
                || permission.contains("VIBRATE")
                || permission.contains("RESTART_PACKAGES")
                || permission.contains("READ_WIFI_CREDENTIAL")
                || permission.contains("ACCESS_FINE_LOCATION")
                || permission.contains("CAMERA")
                || permission.contains("ACCESS_COARSE_LOCATION")
                || permission.contains("READ_PHONE_STATE")
                || permission.contains("ACCOUNT_MANAGER")
                || permission.contains("RECORD_AUDIO"))
    }
}

internal object LibrariesAndDemoCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return (permission.contains("ACCESS_NETWORK_STATE")
                || permission.contains("READ_NETWORK_USAGE_HISTORY")
                || permission.contains("CONTENT_READ")
                || permission.contains("MANAGE_USB")
                || permission.contains("DEVICE_POWER")
                || permission.contains("VIBRATE")
                || permission.contains("RESTART_PACKAGES")
                || permission.contains("READ_WIFI_CREDENTIAL")
                || permission.contains("ACCESS_FINE_LOCATION")
                || permission.contains("CAMERA")
                || permission.contains("ACCESS_COARSE_LOCATION")
                || permission.contains("READ_PHONE_STATE")
                || permission.contains("ACCOUNT_MANAGER")
                || permission.contains("RECORD_AUDIO")
                || permission.contains("ACCESS_BLUETOOTH_SHARE")
                || permission.contains("BLUETOOTH_ADMIN")
                || permission.contains("HIDE_OVERLAY_WINDOWS"))
    }
}

internal object LifestyleCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("READ_GSERVICES") || permission.contains(
            "READ_CONTACTS"
        )
    }
}

internal object MapsAndNavigationCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("READ_GSERVICES") || permission.contains(
            "READ_CONTACTS"
        ) || permission.contains("CALL_PRIVILEGED") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "HIDE_OVERLAY_WINDOWS"
        ) || permission.contains("RECORD_AUDIO") || permission.contains("BLUETOOTH_ADMIN") || permission.contains(
            "NEARBY_WIFI_DEVICES"
        ) || permission.contains("MODIFY_AUDIO_SETTINGS") || permission.contains("GET_TASKS")
    }
}

internal object MedicalCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "RECORD_AUDIO"
        ) || permission.contains("MODIFY_AUDIO_SETTINGS")
    }
}

internal object MusicAndAudioCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "RECORD_AUDIO"
        ) || permission.contains("MODIFY_AUDIO_SETTINGS") || permission.contains("WRITE_SETTINGS")
    }
}

internal object NewsAndMagazinesCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("READ_GSERVICES")
    }
}

internal object ParentingCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "RECORD_AUDIO"
        ) || permission.contains("MODIFY_AUDIO_SETTINGS") || permission.contains("NEARBY_WIFI_DEVICES") || permission.contains(
            "HIDE_OVERLAY_WINDOWS"
        ) || permission.contains("READ_GSERVICES") || permission.contains("READ_CONTACTS") || permission.contains(
            "GET_TASKS"
        ) || permission.contains("WRITE_SETTINGS") || permission.contains("READ_CALENDAR")
    }
}

internal object PersonalizationCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "SET_WALLPAPER"
        ) || permission.contains("WRITE_SETTINGS") || permission.contains("READ_PHONE_STATE")
    }
}

internal object PhotographyCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "RECORD_AUDIO"
        ) || permission.contains("SET_WALLPAPER")
    }
}

internal object ProductivityCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "RECORD_AUDIO"
        ) || permission.contains("READ_CONTACTS") || permission.contains("HIDE_OVERLAY_WINDOWS") || permission.contains(
            "READ_GSERVICES"
        ) || permission.contains("BLUETOOTH_ADMIN")
    }
}

internal object PuzzleCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CHANGE_WIFI_MULTICAST_STATE") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("CHECK_LICENSE")
    }
}

internal object RacingCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CHANGE_WIFI_MULTICAST_STATE") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("CHECK_LICENSE") || permission.contains(
            "SET_ALARM"
        ) || permission.contains("NEARBY_WIFI_DEVICES") || permission.contains("GET_TASKS") || permission.contains(
            "RECORD_AUDIO"
        )
    }
}

internal object RolePlayingCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("READ_PHONE_STATE") || permission.contains("ACCOUNT_MANAGER") || permission.contains(
            "CAMERA"
        ) || permission.contains("ACCESS_COARSE_LOCATION")
    }
}

internal object ShoppingCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("READ_PHONE_STATE") || permission.contains("ACCOUNT_MANAGER") || permission.contains(
            "CAMERA"
        ) || permission.contains("ACCESS_COARSE_LOCATION")
    }
}

internal object SimulationCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "READ_PHONE_STATE"
        )
    }
}

internal object SocialCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "RECORD_AUDIO"
        ) || permission.contains("MODIFY_AUDIO_SETTINGS") || permission.contains("HIDE_OVERLAY_WINDOWS") || permission.contains(
            "READ_GSERVICES"
        ) || permission.contains("READ_CONTACTS") || permission.contains("CALL_PRIVILEGED")
    }
}

internal object SportsCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER")
    }
}

internal object StrategyCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("CHECK_LICENSE") || permission.contains(
            "GET_TASKS"
        ) || permission.contains("NEARBY_WIFI_DEVICES") || permission.contains("USE_CREDENTIALS") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("CAMERA")
    }
}

internal object ToolsCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "NEARBY_WIFI_DEVICES"
        ) || permission.contains("BLUETOOTH_ADMIN") || permission.contains("HIDE_OVERLAY_WINDOWS") || permission.contains(
            "RECORD_AUDIO"
        )
    }
}

internal object TravelAndLocalCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "READ_GSERVICES"
        ) || permission.contains("BLUETOOTH_ADMIN") || permission.contains("HIDE_OVERLAY_WINDOWS") || permission.contains(
            "RECORD_AUDIO"
        ) || permission.contains("CALL_PRIVILEGED")
    }
}

internal object TriviaCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains("READ_PHONE_STATE") || permission.contains(
            "ACCOUNT_MANAGER"
        )
    }
}

internal object VideoPlayersAndEditorsCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("CAMERA") || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains(
            "READ_PHONE_STATE"
        ) || permission.contains("ACCOUNT_MANAGER") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "HIDE_OVERLAY_WINDOWS"
        ) || permission.contains("RECORD_AUDIO") || permission.contains("NEARBY_WIFI_DEVICES") || permission.contains(
            "WRITE_SETTINGS"
        ) || permission.contains("MODIFY_AUDIO_SETTINGS") || permission.contains("CHANGE_NETWORK_STATE") || permission.contains(
            "WRITE_EXTERNAL_STORAGE"
        ) || permission.contains("CHANGE_WIFI_MULTICAST_STATE") || permission.contains("GET_TASKS") || permission.contains(
            "INSTALL_SHORTCUT"
        )
    }
}

internal object WeatherCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains("READ_PHONE_STATE") || permission.contains(
            "ACCOUNT_MANAGER"
        ) || permission.contains("READ_GSERVICES") || permission.contains("ACCESS_BLUETOOTH_SHARE") || permission.contains(
            "CHANGE_WIFI_MULTICAST_STATE"
        ) || permission.contains("CAMERA") || permission.contains("NEARBY_WIFI_DEVICES") || permission.contains(
            "HIDE_OVERLAY_WINDOWS"
        ) || permission.contains("BLUETOOTH_ADMIN")
    }
}

internal object WordCategoryPermissions {
    fun isSafePermission(permission: String): Boolean {
        return permission.contains("ACCESS_NETWORK_STATE") || permission.contains("READ_NETWORK_USAGE_HISTORY") || permission.contains(
            "CONTENT_READ"
        ) || permission.contains("MANAGE_USB") || permission.contains("DEVICE_POWER") || permission.contains(
            "VIBRATE"
        ) || permission.contains("RESTART_PACKAGES") || permission.contains("READ_WIFI_CREDENTIAL") || permission.contains(
            "ACCESS_FINE_LOCATION"
        ) || permission.contains("ACCESS_COARSE_LOCATION") || permission.contains("READ_PHONE_STATE") || permission.contains(
            "ACCOUNT_MANAGER"
        ) || permission.contains("SET_ALARM") || permission.contains("CHECK_LICENSE") || permission.contains(
            "CHANGE_WIFI_MULTICAST_STATE"
        ) || permission.contains("NEARBY_WIFI_DEVICES")
    }
}