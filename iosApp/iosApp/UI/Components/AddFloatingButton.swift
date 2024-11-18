//
//  AddFloatingButton.swift
//  iosApp
//
//  Created by Kuei-Jung Hu on 2024/11/19.
//  Copyright © 2024 Kuei-Jung Hu. All rights reserved.
//

import SwiftUI

struct AddFloatingButton: View {
    
    let onClick: () -> Void
    
    var body: some View {
        Button(
            action: onClick,
            label: {
                Image(systemName: "plus")
                    .resizable()
                    .frame(width: 21, height: 21)
                    .foregroundColor(Color.surface)
            }
        )
        .frame(width: 60, height: 60)
        .background(Color.primary)
        .cornerRadius(30.0)
    }
}

#Preview {
    AddFloatingButton(onClick: {})
}
