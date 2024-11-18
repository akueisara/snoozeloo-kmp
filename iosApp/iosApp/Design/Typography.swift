//
//  Typography.swift
//  iosApp
//
//  Created by Kuei Jung Hu on 2024/11/18.
//  Copyright © 2024 Kuei Jung Hu. All rights reserved.
//

import SwiftUI

public enum Montserrat: String, CaseIterable {
  case regular = "Montserrat-Regular"
  case medium = "Montserrat-Medium"
  case semiBold = "Montserrat-SemiBold"
}

extension Font {
    static let extraLarge: Font = Font.montserrat(Montserrat.medium, size: 42).weight(.medium)
    static let title: Font = Font.montserrat(Montserrat.medium, size: 24).weight(.medium)
    static let headline: Font = Font.montserrat(Montserrat.semiBold, size: 16).weight(.semibold)
    
    private static func montserrat(_ font: Montserrat, size: CGFloat) -> Font {
        return .custom(font.rawValue, size: size)
    }
}
